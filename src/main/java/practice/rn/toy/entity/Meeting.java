package practice.rn.toy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="meeting")
public class Meeting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="meeting_id")
    private Long id;

    private String date;

    private String title;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

}
