package pl.sda.news.views;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ViewStatisticsController {
    @GetMapping("/viewStatistics")
    public List<ViewStatistics> list() {
        ViewStatistics vs1 = new ViewStatistics(1l, 5, 1l);
        ViewStatistics vs2 = new ViewStatistics(2l, 7, 2l);
        ViewStatistics vs3 = new ViewStatistics(3l, 2, 3l);
        return Arrays.asList(vs1, vs2, vs3);

    }
}
