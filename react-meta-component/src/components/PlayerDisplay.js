import { useState } from "react";
import Card from "./Card";

export default function PlayerDisplay({
  cardHands = [[], []],
  bet = {
    baseBet: 0,
    insuranceBet: false,
    doubleDown: false,
    surrender: false,
  },
}) {
  return <div />;
}
