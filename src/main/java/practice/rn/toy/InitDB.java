package practice.rn.toy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import practice.rn.toy.entity.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final EntityManager em;

        public void dbInit(){
            Member member1=createMember("a@gmail.com","aaa");
            em.persist(member1);

            Member member2=createMember("b@gmail.com","bbb");
            em.persist(member2);

            Member member3=createMember("c@gmail.com","ccc");
            em.persist(member3);

            Member member4=createMember("d@gmail.com","ddd");
            em.persist(member4);

            Group group1=createGroup("qqq",member1,member2,member3);
//            em.persist(group1);


            Group group2=createGroup("www",member2,member3,member4);
//            em.persist(group2);


            Meeting meeting1=createMeeting(group1,"qqq meeting1","20220226");
            em.persist(meeting1);
//            group1.getMeetingList().add(meeting1);

            Meeting meeting2=createMeeting(group1,"qqq meeting2","20220314");
            em.persist(meeting2);
//            group1.getMeetingList().add(meeting2);

            Meeting meeting3=createMeeting(group2,"www meeting1","20220227");
            em.persist(meeting3);
//            group2.getMeetingList().add(meeting3);


            Friend friend1=createFriend(member1,member2);
            em.persist(friend1);

            Friend friend2=createFriend(member1,member3);
            em.persist(friend2);

            Friend friend3=createFriend(member2,member3);
            em.persist(friend3);

        }

        private Member createMember(String email,String name){
            Member member=new Member();
            member.setEmail(email);
            member.setName(name);

            return member;
        }
        private Group createGroup(String title,Member member1,Member member2,Member member3){
            Group group=new Group();
            group.setTitle(title);
            em.persist(group);

            MemberGroup mg1=new MemberGroup();
            mg1.setMember(member1);
            mg1.setGroup(group);
            em.persist(mg1);
//            member1.getGroupList().add(mg1);

            MemberGroup mg2=new MemberGroup();
            mg2.setMember(member2);
            mg2.setGroup(group);
            em.persist(mg2);
//            member2.getGroupList().add(mg2);

            MemberGroup mg3=new MemberGroup();
            mg3.setMember(member3);
            mg3.setGroup(group);
            em.persist(mg3);
//            member3.getGroupList().add(mg3);

            return group;
        }
        private Meeting createMeeting(Group group, String title,String date){
            Meeting meeting=new Meeting();
            meeting.setDate(date);
            meeting.setGroup(group);
            meeting.setTitle(title);
//            em.persist(meeting);
//            group.getMeetingList().add(meeting);

            return meeting;
        }

        private Friend createFriend(Member member1,Member member2){
            Friend friend=new Friend();
            friend.setMaster(member1);
            friend.setSlave(member2);

            return friend;
        }
    }
}
