package org.example.controller;

import org.example.Container;
import org.example.util.Util;
import org.example.vo.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberController {

    private int lastId = 3;
    private List<Member> memberList = new ArrayList<Member>();

    public void join() {

        System.out.println("== 회원가입 ==");
        String loginId = null;
        while(true){
            System.out.print("아이디 : ");
            loginId = Container.getScanner().nextLine().trim();
            if (isJoinableLoginId(loginId)) {
                System.out.println("사용 가능한 아이디 입니다.");
                break;
            } else {
                System.out.println("중복된 아이디입니다. 다시 입력하세요.");
            }
        }

        String loginPass = null;
        while(true){
            System.out.print("비밀번호 : ");
            loginPass = Container.getScanner().nextLine().trim();
            System.out.print("비밀번호 확인 : ");
            String loginPassChk = Container.getScanner().nextLine().trim();

            if(!loginPass.equals(loginPassChk)){
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }
            break;
        }
        System.out.print("이름 : ");
        String loginName = Container.getScanner().nextLine().trim();
        ++lastId;

        String NowDate = Util.nowDate();

        Member newMember = new Member(lastId,loginId,loginPass,loginName,NowDate);
        memberList.add(newMember);

        System.out.println(lastId + "번 회원이 등록되었습니다.(개발자용)");
        System.out.println(loginName + "회원님 등록을 환영합니다.");

    }

    public void list() {
        System.out.println("=".repeat(30));
        for (Member member : memberList) {
            System.out.println("member" + member.toString());
        }
    }

    private boolean isJoinableLoginId(String loginId) {
        for(Member members : memberList){
            if(members.getLoginId().equals(loginId)) {
                return false;
            }
        }
        return true;
    }

    public void makeTestData() {
        memberList.add(new Member(1,"aaa","zzz","홍길동","2025-08-31 12:30:30"));
        memberList.add(new Member(2,"bbb","xxx","김철수","2025-08-31 12:30:30"));
        memberList.add(new Member(3,"ccc","ccc","김영희","2025-08-31 12:30:30"));
    }

}
