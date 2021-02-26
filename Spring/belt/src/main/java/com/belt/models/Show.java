package com.belt.models;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, message="You have to provide a title")
    private String title;

    @Size(min=1, message="You have to provide the network")
    private String network;

    private Double avgRating;

    @Column(updatable=false)
    private Date createdAt;

    private Date updatedAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userT;

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="show", fetch = FetchType.LAZY)
    private List<Review> reviews;


    public Show() {
    }

    public Show(Long id, @Size(min = 1, message = "You have to provide a title") String title, @Size(min = 1, message = "You have to provide the network") String network, Double avgRating, User userT, List<Review> reviews, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.network = network;
        this.avgRating = avgRating;
        this.userT = userT;
        this.reviews = reviews;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUserT() {
        return userT;
    }

    public void setUserT(User userT) {
        this.userT = userT;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
