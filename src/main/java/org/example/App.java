package org.example;

import org.example.controller.ArticleController;
import org.example.controller.MemberController;
import org.example.system.SystemController;

public class App {

    public void run() {

        SystemController systemController = new SystemController();
        ArticleController articleController = new ArticleController();
        MemberController memberController = new MemberController();

        systemController.start();
        articleController.make();
        memberController.make();

        while(true){

            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();

            if(cmd.length()== 0){
                System.out.println("명령어를 입력하세요");
                continue;
            }
            if(cmd.equals("exit")){
                systemController.exit();
                break;
            } else if (cmd.equals("member join")) {
                memberController.join();
            } else if (cmd.equals("member list")) {
                memberController.list();
            } else if(cmd.equals("article write")){
                articleController.write();
            } else if (cmd.startsWith("article list")) {
                articleController.list(cmd);
            } else if (cmd.startsWith("article detail")){
                articleController.detail(cmd);
            } else if (cmd.startsWith("article delete")){
                articleController.delete(cmd);
            } else if(cmd.startsWith("article modify")){
                System.out.println("==게시글 수정==");
                articleController.modify(cmd);
            } else {
                System.out.println("사용할 수 없는 명령어입니다.");
            }
        }

    }
}
