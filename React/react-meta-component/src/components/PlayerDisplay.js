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
  return (
    <div
      className={
        "flex" +
        " " +
        "column" +
        " " +
        "center-align" +
        " " +
        "space-evenly-justify" +
        " " +
        "set-height-35vh"
      }
    >
      <div
        className={
          "flex" +
          " " +
          "column" +
          " " +
          "bgColor-antiquewhite" +
          " " +
          "set-width-60vw" +
          " " +
          "padding-top" +
          " " +
          "padding-bottom" +
          " " +
          "border-radius-10px"
        }
      >
        <div
          className={
            "flex" + " " + "space-around-justify" + " " + "set-width-100percent"
          }
        >
          <Card src={"Images/3H.svg"} alt={"Three of hearts"} width={"125px"} />
          <Card src={"Images/8C.svg"} alt={"Eight of clubs"} width={"125px"} />
          <Card src={"Images/2D.svg"} alt={"Two of diamonds"} width={"125px"} />
          <Card src={"Images/5S.svg"} alt={"Five of spades"} width={"125px"} />
        </div>
        <div
          className={
            "flex" + " " + "space-around-justify" + " " + "center-align"
          }
        >
          <div
            className={
              "flex" +
              " " +
              "center-align" +
              " " +
              "font-size" +
              " " +
              "bgColor-burlywood" +
              " " +
              "border-radius" +
              " " +
              "padding" +
              " " +
              "set-height-10vh"
            }
          >
            <div className={"color-black"}>Stand</div>
          </div>
          <div
            className={
              "flex" +
              " " +
              "center-align" +
              " " +
              "font-size" +
              " " +
              "bgColor-burlywood" +
              " " +
              "border-radius" +
              " " +
              "padding" +
              " " +
              "set-height-10vh"
            }
          >
            <div className={"color-black"}>Hit</div>
          </div>

          <div
            className={
              "flex" +
              " " +
              "center-align" +
              " " +
              "font-size" +
              " " +
              "color-black" +
              " " +
              "bgColor-red" +
              " " +
              "border-radius-100percent" +
              " " +
              "padding-20px" +
              " " +
              "set-height-10vh" +
              " " +
              "set-width-10vh"
            }
          >
            <div
              className={"flex" + " " + "center-justify" + " " + "color-black"}
            >
              Bet
            </div>
          </div>

          <div
            className={
              "flex" +
              " " +
              "center-align" +
              " " +
              "font-size" +
              " " +
              "bgColor-burlywood" +
              " " +
              "border-radius" +
              " " +
              "padding" +
              " " +
              "set-height-10vh"
            }
          >
            <div>
              <div className={"color-black"}>Double</div>
              <div className={"color-black"}>Down</div>
            </div>
          </div>

          <div
            className={
              "flex" +
              " " +
              "center-align" +
              " " +
              "font-size" +
              " " +
              "color-black" +
              " " +
              "bgColor-burlywood" +
              " " +
              "border-radius" +
              " " +
              "padding" +
              " " +
              "set-height-10vh"
            }
          >
            <div className={"color-black"}>Split</div>
          </div>
        </div>
      </div>
    </div>
  );
}
