package com.example.wantedpreonboardingbackend.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoDTO {
    private String pageTitle;
    private String content;
    private List<PageInfoDTO> subPages;
    private PageInfoDTO parentPage;
    private List<String> breadcrumbs;


    public void addSubpage(PageInfoDTO subpage) {
        subPages.add(subpage);
    }
}
