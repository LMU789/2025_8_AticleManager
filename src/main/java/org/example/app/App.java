package org.example.app;

import org.example.controller.ArticleController;
import org.example.controller.Controller;
import org.example.controller.MemberController;
import org.example.system.SystemController;
import org.example.util.Container;

public class App {

    SystemController systemController = new SystemController();
    ArticleController articleController = new ArticleController();
    MemberController memberController = new MemberController();
    Controller controller = null;

    public void run() {

        systemController.start();
        articleController.makeTestData();
        memberController.makeTestData();

        while(true){

            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();

            if(cmd.equals("exit")){
                systemController.exit();
                break;
            } else if (cmd.equals("help")) {
                systemController.help();
            }

            String[] cmdBits = cmd.split(" ");
            String controllerName = cmdBits[0];
            String controllerMethodName = cmdBits[1];

            if(cmd.length() == 0){
                System.out.println("명령어를 입력하세요");
                continue;
            }

            if(controllerName.equals("article")) {
                controller = articleController;
            } else if(controllerName.equals("member")){
                controller = memberController;
            } else {
                System.out.println("사용할 수 없는 명령어입니다.");
                continue;
            }

            controller.doAction(cmd, controllerMethodName);

//            if (cmd.equals("member join")) {
//                memberController.join();
//            } else if (cmd.equals("member list")) {
//                memberController.list();
//            } else if(cmd.equals("article write")){
//                articleController.write();
//            } else if (cmd.startsWith("article list")) {
//                articleController.list();
//            } else if (cmd.startsWith("article detail")){
//                articleController.detail();
//            } else if (cmd.startsWith("article delete")){
//                articleController.delete();
//            } else if(cmd.startsWith("article modify")){
//                System.out.println("==게시글 수정==");
//                articleController.modify();
//            } else {
//                System.out.println("사용할 수 없는 명령어입니다.");
//            }

        }

    }
}
