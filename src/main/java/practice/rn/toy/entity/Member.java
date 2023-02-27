package practice.rn.toy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String email;
    private String name;

    @OneToMany(mappedBy = "member")
    private List<MemberGroup> groupList;

//    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
//    private List<Friend> friendList;


}
