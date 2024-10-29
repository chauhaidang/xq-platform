package com.xq.cards.service;

import com.xq.cards.Constants;
import com.xq.cards.dto.CardDto;
import com.xq.cards.entity.Card;
import com.xq.cards.exception.CardAlreadyExistsException;
import com.xq.cards.exception.ResourceNotFoundException;
import com.xq.cards.mapper.CardMapper;
import com.xq.cards.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class CardServiceImpl implements ICardService {

    private CardRepository cardRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> found = cardRepository.findByMobileNumber(mobileNumber);
        if (found.isPresent()) {
            throw new CardAlreadyExistsException("Card already exists with mobile number: " + mobileNumber);
        }
        cardRepository.save(createNewCard(mobileNumber));
    }

    @Override
    public CardDto fetchCard(String mobileNumber) {
        Card foundCard = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return CardMapper.mapToCardDto(foundCard, new CardDto());
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        Card card = cardRepository.findByCardNumber(cardDto.getCardNumber()).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "loanNumber", cardDto.getCardNumber())
        );
        card = CardMapper.mapToCard(cardDto, card);
        cardRepository.save(card);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Card foundCard = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        cardRepository.deleteById(foundCard.getCardId());
        return true;
    }

    private Card createNewCard(String mobileNumber) {
        Card card = new Card();
        long randomCardNum = 100000000000L + new Random().nextInt(900000000);
        card.setMobileNumber(mobileNumber);
        card.setCardNumber(Long.toString(randomCardNum));
        card.setCardType(Constants.DEFAULT_CARD_TYPE);
        card.setTotalLimit(Constants.NEW_CARD_LIMIT);
        card.setAmountUsed(0);
        card.setAvailableAmount(Constants.NEW_CARD_LIMIT);
        return card;
    }
}
