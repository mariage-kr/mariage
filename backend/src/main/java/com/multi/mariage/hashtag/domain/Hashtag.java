package com.multi.mariage.hashtag.domain;

import com.multi.mariage.review_hashtag.domain.ReviewHashtag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hashtag")
    private List<ReviewHashtag> reviewHashTags = new ArrayList<>();


    public Hashtag(String name) {

        this.name = name;

        // hashtag를 영속성 컨텍스트에서 삭제한 후, 데이터베이스에 반영하기 위해 트랜젝션을 커밋하는 함.
        if (reviewHashTags.size() == 0) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hashtag");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.remove(this);
            tx.commit();

            em.close();
            emf.close();
            }
        }
    }

