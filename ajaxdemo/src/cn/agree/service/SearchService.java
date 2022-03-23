package cn.agree.service;

import cn.agree.dao.SearchDao;
import cn.agree.pojo.User01;

import java.util.List;

public class SearchService {

    public List<User01> search(String word) {
        System.out.println("SearchService.search...");
        SearchDao searchDao = new SearchDao();
        List<User01> user01List = null;

        try {
            user01List = searchDao.findUserByLikeName(word);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user01List;
    }
}
