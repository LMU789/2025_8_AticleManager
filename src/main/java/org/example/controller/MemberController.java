package org.example.controller;

import org.example.util.Container;
import org.example.util.Util;
import org.example.vo.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberController extends Controller {

    private int lastId = 3;
    private List<Member> memberList = new ArrayList<Member>();
    private String cmd;
    private Member logindMember;

    @Override
    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;
        switch (actionMethodName) {
            case "join":
                if(isLogined()){
                    System.out.println("로그아웃 하고 이용 가능합니다.");
                    return;
                }
                join();
                break;
            case "list":
                list();
                break;
            case "login":
                if(isLogined()){
                    System.out.println("로그아웃 하고 이용 가능합니다.");
                    return;
                }
                login();
                break;
            case "logout":
                if(!isLogined()){
                    System.out.println("로그아웃 하고 이용 가능합니다.");
                    return;
                }
                logout();
                break;
            default:
                break;
        }
    }

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

    public void login() {
//        while(true){
//            System.out.print("아이디 : ");
//            String loginId = Container.getScanner().nextLine().trim();
//            System.out.print("비밀번호 : ");
//            String loginPass = Container.getScanner().nextLine().trim();
//            if (isJoinableLogin(loginId,loginPass)) {
//                System.out.println("로그인 되었습니다.");
//                String name = chkName(loginId);
//                System.out.println(name + "님 환영합니다.");
//                break;
//            } else {
//                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
//            }
//        }

        if(!isLogined()) {
            System.out.println("이미 로그인 되었습니다.");
            return;
        }

        System.out.print("아이디 : ");
        String loginId = Container.getScanner().nextLine().trim();
        System.out.print("비밀번호 : ");
        String loginPass = Container.getScanner().nextLine().trim();

        Member member = getMemberByLoginId(loginId);

        if (member == null) {
            System.out.println("일치하는 회원이 없습니다.");
        }

        if(member.getLoginPassword().equals(loginPass)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        logindMember = member;

        System.out.println(logindMember.getLoginName() +"님 로그인 성공");

    }

    public void logout() {
        if(isLogined()){
            System.out.println("로그아웃인 상태입니다.");
            return;
        }
        logindMember = null;
        System.out.println("로그아웃되었습니다.");
    }

    private Member getMemberByLoginId(String loginId) {
        for(Member member : memberList){
            if(!member.getLoginId().equals(loginId)) {
                return member;
            }
        }
        return null;
    }

    private boolean isJoinableLoginId(String loginId) {
        for(Member members : memberList){
            if(members.getLoginId().equals(loginId)) {
                return false;
            }
        }
        return true;
    }

    private boolean isJoinableLogin(String loginId, String loginPass) {
        for(Member members : memberList){
            if(members.getLoginId().equals(loginId) && members.getLoginId().equals(loginPass)) {
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
