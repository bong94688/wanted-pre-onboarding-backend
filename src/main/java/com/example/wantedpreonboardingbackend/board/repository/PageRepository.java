package com.example.wantedpreonboardingbackend.board.repository;

import com.example.wantedpreonboardingbackend.board.dto.PageInfoDTO;
import com.example.wantedpreonboardingbackend.board.entity.ParentPage;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PageRepository {

    private final JdbcTemplate jdbcTemplate;

//    private static String GET_CRUMB_QUERY = "SELECT "
//            + "id, content, page_title "
//            + "FROM PAGE WHERE id = ?";
//
//
//
//    public PageInfoDTO getPageInfo(Long pageId) {
//        String query = "SELECT p1.id, p1.pageTitle, p1.content, p2.id AS subpage_id, p2.title AS subpage_title "
//                + "FROM PAGE p1 "
//                + "LEFT JOIN PAGE p2 ON p1.id = p2.id "
//                + "WHERE p1.id = ?";
//
//        return jdbcTemplate.queryForObject(query, new Object[]{pageId}, (rs, rowNum) -> {
//            PageInfoDTO pageInfo = new PageInfoDTO();
//            pageInfo.setPageTitle(rs.getString("title"));
//            pageInfo.setContent(rs.getString("content"));
//
//            do {
//                Long subpageId = rs.getLong("id");
//                if (subpageId > 0) {
//                    pageInfo.addSubpage(pageInfo);
//                }
//            } while (rs.next());
//
//            return pageInfo;
//        });
//    }


//    public PageInfoDTO getPage(Long id) {
//        String breadCrumbsSql = "SELECT parent_page_id FROM sub_pages WHERE sub_page_id = ? ORDER BY depth ASC";
//        String subPageSql = "SELECT sub_page_id FROM sub_pages WHERE parent_page_id = ? AND depth = 1";
//        String getPageSql = "SELECT * FROM pages p WHERE id = ?";
//        List<Long> breadCrumbs = jdbcTemplate.query(breadCrumbsSql, (ResultSet rs, int rowNum) -> {
//            return rs.getLong("parent_page_id");
//        }, id);
//        List<Long> subpages = jdbcTemplate.query(subPageSql, (ResultSet rs, int rowNum) -> {
//            return rs.getLong("sub_page_id");
//        }, id);
//        ParentPage page = jdbcTemplate.queryForObject(getPageSql, (ResultSet rs, int rowNum) -> {
//            return new ParentPage(rs.getLong("id"), rs.getString("title"), rs.getString("content"));
//        }, id);
//
//        return PageInfoDTO.builder()
//                .id(page.getId())
//                .title(page.getTitle())
//                .content(page.getContent())
//                .breadCrumbs(breadCrumbs)
//                .subPages(subpages).build();
//    }


}
