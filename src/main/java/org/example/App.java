package org.example;

import org.example.controller.ArticleController;
import org.example.system.SystemController;

public class App {

    public void run() {

        SystemController systemController = new SystemController();
        ArticleController articleController = new ArticleController();

        systemController.start();

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
            }
            if(cmd.equals("article write")){
                articleController.write();
            } else if (cmd.equals("article list")) {
                articleController.list();
            } else if (cmd.equals("article detail")){
                articleController.detail(cmd);

            } else if (cmd.startsWith("article delete")){
                articleController.delete(cmd);
            } else if(cmd.startsWith("article modify")){
                articleController.modify(cmd);
            } else {
                System.out.println("사용할 수 없는 명령어입니다.");
            }
        }

    }
}
