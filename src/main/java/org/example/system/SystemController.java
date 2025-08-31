package org.example.system;

public class SystemController {

    public void start() {
        System.out.println("== 프로그램 시작 ==");
//        System.out.println("== 게시판 시작 ==");
    }

    public void exit() {
        System.out.println("프로그램 종료");
//        System.out.println("== 게시판 종료 ==");
    }

    public void help() {
        System.out.println("== 사용 가능한 커맨드 ==");
        System.out.println("member join : 회원가입");
        System.out.println("member list : 등록된 가입자 명단");
        System.out.println("member login : 등록된 가입자 명단");
        System.out.println("member logout : 등록된 가입자 명단");
        System.out.println("article write : 게시글 작성");
        System.out.println("article list : 등록된 게시글 목록");
        System.out.println("article detail : 특정 게시글 보는 커맨드");
        System.out.println("article delete : 게시글 삭제 커맨드");
        System.out.println("article modify : 게시글 수정 커맨드");
    }

}
