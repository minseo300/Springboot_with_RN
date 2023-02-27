package practice.rn.toy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Friend {
    @Id @GeneratedValue
    @Column(name="friend_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="master")
    private Member master;

    @ManyToOne
    @JoinColumn(name="slave")
    private Member slave;





}
