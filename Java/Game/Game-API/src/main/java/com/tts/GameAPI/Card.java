package com.tts.GameAPI;

import com.tts.GameAPI.cardClasses.Image;
import com.tts.GameAPI.cardClasses.Ranks;
import com.tts.GameAPI.cardClasses.Suits;

public record Card(int id, Suits suit, Ranks rank, Image image) {
}

