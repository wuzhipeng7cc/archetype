#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.db.model;

import javax.persistence.*;

public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Test(Integer id) {
        this.id = id;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }
}