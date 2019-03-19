package com.mzyan.springboot.service;

import com.mzyan.springboot.bean.Employee;
import com.mzyan.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * @Cacheable：将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法
     * CacheManager 管理多个 Cache 组件，对缓存的真正CRUD操作在Cache中，每一个缓存组件都有自己唯一的名字
     *      cacheNames/value: 指定缓存组件的名字，数组的方式，可以指定多个缓存
     *      key：缓存数据使用的key，可以用它来指定。默认是使用方法参数的值
     *          可编写SpEL: #id 参数id的值，#a0  #p0  #root.args[0]
     *      keyGenerator: key 的生成器，可以自己指定key的生成器的组件id
     *          key/keyGenerator：二选一使用
     *      cacheManager：指定缓存管理器，或者cacheResolver指定获取解析器
     *      condition：指定符合条件的情况下才缓存，condition = "#id>0"
     *      unless：否定缓存，当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *          unless = "#result == null"
     *      sync：是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(value = {"emp"}, keyGenerator = "myKeyGenerator", condition = "#id>1", unless = "#id==2")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmployeeById(id);
        return emp;
    }
}
