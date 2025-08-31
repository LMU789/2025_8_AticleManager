package org.example.controller;

import org.example.Container;
import org.example.util.Util;
import org.example.vo.Article;
import org.example.vo.Rq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArticleController {

    int lastId = 0;
    List<Article> articleList = new ArrayList<Article>();

    public void write() {

        System.out.print("제목 : ");
        String title = Container.getScanner().nextLine().trim();
        System.out.print("내용 : ");
        String body = Container.getScanner().nextLine().trim();
        ++lastId;

        String NowDate = Util.nowDate();

        Article newArticle = new Article(lastId,NowDate,title,body);

        articleList.add(newArticle);

        System.out.println("내용이 등록 되었습니다.");

    }

    public void list() {
        System.out.println("=".repeat(30));
        System.out.println("번호      /      제목     /      내용     /      날짜");

        if (articleList.size() == 0) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            Collections.reverse(articleList);
            for (Article article : articleList) {
                if (article.getBody().length() < 5) {
                    System.out.println(" " + article.getId() + "               " + article.getTitle() + "            " + article.getBody() + "            " + article.getReqDate());
                } else {
                    System.out.println(" " + article.getId() + "               " + article.getTitle() + "            " + article.getBody().substring(0, 5) + "            " + article.getReqDate());
                }
            }
        }
    }

    public void detail(String cmd) {

        int id = -1;
        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (NumberFormatException e) {
            System.out.println("articleDetail 뒤에는 숫자만 입력 가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("articleDetail 한칸 띄고 숫자 입력하십시오.");
            return;
        }

        Article foundArticle = null;
        for(Article article : articleList) {
            if(article.getId() == id) {
                foundArticle = article;
                break;
            }
        }

        if(foundArticle == null) {
            System.out.println(id + "번 글은 없습니다.");
            return;
        }

        System.out.println("번호 : " + foundArticle.getId());
        System.out.println("등록일 : " + foundArticle.getReqDate());
        System.out.println("수정일 : " + foundArticle.getUpdateDate());
        System.out.println("제목 : " + foundArticle.getTitle());
        System.out.println("내용 : " + foundArticle.getBody());
    }

    public void delete(String cmd) {

        int id = -1;
        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (NumberFormatException e) {
            System.out.println("articledelete 뒤에는 숫자만 입력 가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("articledelete 한칸 띄고 숫자 입력하십시오.");
            return;
        }


        Article foundArticle = null;
        for(Article article : articleList) {
            if(article.getId() == id) {
                foundArticle = article;
                break;
            }
        }

        if(foundArticle == null) {
            System.out.println(id + "번 글은 없습니다.");
            return;
        }

        articleList.remove(foundArticle);
        System.out.println(id + "번 글이 삭제되었습니다.");

    }

    public void modify(String cmd) {

        int id = -1;
        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (NumberFormatException e) {
            System.out.println("articledelete 뒤에는 숫자만 입력 가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("articledelete 한칸 띄고 숫자 입력하십시오.");
            return;
        }

        Article foundArticle = null;
        for(Article article : articleList) {
            if(article.getId() == id) {
                foundArticle = article;
                break;
            }
        }

        System.out.println("기존 제목 : " + foundArticle.getTitle());
        System.out.println("기존 내용 : " + foundArticle.getBody());
        System.out.print("변경할 제목 : ");
        String newTitle = Container.getScanner().nextLine().trim();
        System.out.print("변경할 내용 : ");
        String newBody = Container.getScanner().nextLine().trim();

        String NowDate = Util.nowDate();

        foundArticle.setTitle(newTitle);
        foundArticle.setBody(newBody);
        foundArticle.setUpdateDate(NowDate);
        System.out.println(id + "번 글이 업데이트되었습니다.");

    }
}
