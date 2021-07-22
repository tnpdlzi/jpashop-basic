package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

//    // 이상한 부분? Order를 찾아왔다. 관계형 디비에 맞춘 설계. 객체에 맞춘 게 아니라. 객체 그래프 탐색이 불가능.
//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    // 이게 객체에 맞춘 설계.
    @ManyToOne
    @JoinColumn(name = "MEMEBER_ID")
    private Member member;

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate; // orderDate가 아닌 order_date로 되도록 부트에서 설정을 바꿀 수 있다.

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // == 연관관계 편의 메서드 == //
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
