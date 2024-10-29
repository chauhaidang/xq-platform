package com.xq.cards.service;

import com.xq.cards.dto.CardDto;

public interface ICardService {
    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);

    boolean updateCard(CardDto loanDto);

    boolean deleteCard(String mobileNumber);
}
