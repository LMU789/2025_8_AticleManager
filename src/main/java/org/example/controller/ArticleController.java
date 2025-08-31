package org.example.controller;

import org.example.Container;
import org.example.util.Util;
import org.example.vo.Article;
import org.example.vo.Rq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleController {

    int lastId = 3;
    static List<Article> articleList = new ArrayList<Article>();
    int id = -1;

    public void write() {

        System.out.println("== 게시글 작성 ==");
        System.out.print("제목 : ");
        String title = Container.getScanner().nextLine().trim();
        System.out.print("내용 : ");
        String body = Container.getScanner().nextLine().trim();
        ++lastId;

        String NowDate = Util.nowDate();

        Article newArticle = new Article(lastId,title,body,NowDate);

        articleList.add(newArticle);

        System.out.println("내용이 등록 되었습니다.");

    }

    public void list(String cmd) {
        System.out.println("=".repeat(30));
        System.out.println("번호      /      제목     /      내용     /      날짜");

        if (articleList.size() == 0) {
            System.out.println("등록된 게시글이 없습니다.");
            return;
        }

        String searchKeyword = cmd.substring("article list".length()).trim();

        List<Article> forPrintArticles = articleList;

        if(searchKeyword.length() > 0){
            forPrintArticles = new ArrayList<>();
            System.out.println("검색어 : " + searchKeyword);
            for(Article article : articleList){
                if(article.getTitle().contains(searchKeyword)){
                    forPrintArticles.add(article);
                }
            }
            if(forPrintArticles.size() == 0){
                System.out.println("검색결과 없음");
                return;
            }
        }

        for (int i = forPrintArticles.size() - 1; i >= 0; i--) {
            System.out.printf("%d      /      %s      /      %s      /      %s\n", forPrintArticles.get(i).getId(), forPrintArticles.get(i).getTitle(), forPrintArticles.get(i).getBody(), forPrintArticles.get(i).getRegDate());
        }
    }

    public void detail(String cmd) {


        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (NumberFormatException e) {
            System.out.println("articleDetail 뒤에는 숫자만 입력 가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("articleDetail 한칸 띄고 숫자 입력하십시오.");
            return;
        }

        Article foundArticle = getArticleById(id);

        if(foundArticle == null) {
            System.out.println(id + "번 글은 없습니다.");
            return;
        }

        System.out.println("번호   : " + foundArticle.getId());
        System.out.println("등록일 : " + foundArticle.getRegDate());
        System.out.println("수정일 : " + foundArticle.getUpdateDate());
        System.out.println("제목   : " + foundArticle.getTitle());
        System.out.println("내용   : " + foundArticle.getBody());
    }

    public void delete(String cmd) {

        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (NumberFormatException e) {
            System.out.println("articledelete 뒤에는 숫자만 입력 가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("articledelete 한칸 띄고 숫자 입력하십시오.");
            return;
        }

        Article foundArticle = getArticleById(id);

        if(foundArticle == null) {
            System.out.println(id + "번 글은 없습니다.");
            return;
        }

        articleList.remove(foundArticle);
        System.out.println(id + "번 글이 삭제되었습니다.");

    }

    public void modify(String cmd) {

        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (NumberFormatException e) {
            System.out.println("articledelete 뒤에는 숫자만 입력 가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("articledelete 한칸 띄고 숫자 입력하십시오.");
            return;
        }

        Article foundArticle = getArticleById(id);

        if(foundArticle == null) {
            System.out.println(id + "번 글은 없습니다.");
            return;
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

    public void make() {
        makeTestDate();
    }

    private static void makeTestDate() {
        System.out.println("테스트 데이터 생성됨");
        articleList.add(new Article(1,"제목1","내용1","2025-08-31 12:30:30"));
        articleList.add(new Article(2,"제목2","내용2","2025-08-30 11:35:22"));
        articleList.add(new Article(3,"제목3","내용3","2025-08-29 15:11:53"));
    }

    private static Article getArticleById(int id) {
        for(Article article : articleList) {
            if(article.getId() == id) {
                return article;
            }
        }

        return null;
    }
}
