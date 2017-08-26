package com.github.flyfor.model;

/**
 * Created on 2017. 8. 26..
 */
public class ExternalApiResponse {
    SearchParameter searchParameter;
    SearchResult searchResult;

    public SearchParameter getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(SearchParameter searchParameter) {
        this.searchParameter = searchParameter;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }
}
