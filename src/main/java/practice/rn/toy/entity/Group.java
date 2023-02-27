package practice.rn.toy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="gather")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="group_id")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private List<Meeting> meetingList;
}
