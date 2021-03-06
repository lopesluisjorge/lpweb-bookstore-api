package br.edu.ifma.bookstore.book;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE book SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted_at IS NULL")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String isbn;

    @NotNull
    @Size(min = 5)
    private String title;

    @NotBlank
    @Column(name = "publishing_company")
    private String publishingCompany;

    @NotBlank
    private String author;

    @Column(name = "release_year")
    private Integer releaseYear;

    private String subject;

    @ManyToMany
    @JoinTable(name = "book_tag",
               joinColumns = @JoinColumn(name = "book_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private final Set<Tag> tags = new LinkedHashSet<>();

    @NotNull
    @Positive
    private BigDecimal price;

    @PositiveOrZero
    private Integer stock = 0;

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @PrePersist
    public void beforeInsert() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void add(Tag... tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

    public Integer addToStock(Integer quantity) {
        return stock += quantity;
    }

    public void removeFromStock() {
        stock--;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
