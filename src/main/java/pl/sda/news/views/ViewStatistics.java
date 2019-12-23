package pl.sda.news.views;

public class ViewStatistics {
    private long id;
    private int viewCounts;
    private long articleId;

    public ViewStatistics(long id, int viewCounts, long articleId) {
        this.id = id;
        this.viewCounts = viewCounts;
        this.articleId = articleId;
    }

    public long getId() {
        return id;
    }

    public int getViewCounts() {
        return viewCounts;
    }

    public long getArticleId() {
        return articleId;
    }
}
