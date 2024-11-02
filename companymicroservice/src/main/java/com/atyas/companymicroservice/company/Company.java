package com.atyas.companymicroservice.company;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String description;

    // MS


    // avant architecture MS
/*    @JsonIgnore
    @OneToMany(mappedBy = "company") // attribut permet de supprimer la table de jointure qui devient inutile
    private List<Job> jobs;


    @OneToMany(mappedBy = "company")
    private  List<Review> reviews;*/

    public Company() {
    }


    // avant architecture MS
/*    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // avant architecture MS
/*    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }*/
}
