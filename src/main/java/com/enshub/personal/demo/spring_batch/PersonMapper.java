package com.enshub.personal.demo.spring_batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by szty on 2018/9/19.
 */
public class PersonMapper implements FieldSetMapper<Person> {
    public Person mapFieldSet(FieldSet fs) throws BindException {
        Person u = new Person();
        u.setName(fs.readString(0));
        u.setAge(fs.readInt(1));
        return u;
        }
}
