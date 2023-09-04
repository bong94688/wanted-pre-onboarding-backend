package com.example.wantedpreonboardingbackend.board.repository;

import com.example.wantedpreonboardingbackend.board.dto.PageInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageRepository {

    private final JdbcTemplate jdbcTemplate;

    private static String GET_CRUMB_QUERY = "SELECT "
            + "id, content, page_title "
            + "FROM PAGE WHERE id = ?";



    public PageInfoDTO getPageInfo(Long pageId) {
        String query = "SELECT p1.id, p1.pageTitle, p1.content, p2.page_id AS subpage_id, p2.title AS subpage_title "
                + "FROM PAGE p1 "
                + "LEFT JOIN PAGE p2 ON p1.id = p2.id "
                + "WHERE p1.id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{pageId}, (rs, rowNum) -> {
            PageInfoDTO pageInfo = new PageInfoDTO();
            pageInfo.setPageTitle(rs.getString("title"));
            pageInfo.setContent(rs.getString("content"));

            do {
                Long subpageId = rs.getLong("id");
                if (subpageId > 0) {
                    pageInfo.addSubpage(pageInfo);
                }
            } while (rs.next());

            return pageInfo;
        });
    }
}
