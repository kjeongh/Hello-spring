package hello.hellospring.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 엔티티의 주키를 생성할 때 사용해야 하는 주키생성 전략

    private Long id;
    @Column(name="username") //db의 컬럼명 username과 매핑
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
