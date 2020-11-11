package com.zsh.springcloud.pojo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @date 2020/11/8 - 9:50
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
private Long deptno;
private String dname;
private  String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
