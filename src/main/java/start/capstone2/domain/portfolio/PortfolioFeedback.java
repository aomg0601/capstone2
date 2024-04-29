package start.capstone2.domain.portfolio;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import start.capstone2.domain.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioFeedback {

    @Id
    @GeneratedValue
    @Column(name = "portfolio_feedback_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Portfolio portfolio;
    private String content;
    private Integer location;


    public static PortfolioFeedback createPortfolioFeedback(User user, Portfolio portfolio, String content, Integer location) {
        PortfolioFeedback feedback = new PortfolioFeedback();
        feedback.user = user;
        feedback.portfolio = portfolio;
        feedback.content = content;
        feedback.location = location;

        return feedback;
    }

    public void updateFeedback(String content, Integer location) {
        this.content = content;
        this.location = location;
    }

}