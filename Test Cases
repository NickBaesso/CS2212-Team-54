=== Test Cases ===


-------------------------------------------------------------------------------------------
Test ID               | TC_CoinGecko_Login_1
--------------------- | -------------------------------------------------------------------
Category              | The login portion of this application is being tested. That is, the
                      | part that takes the user login info and verifies their credentials.
--------------------- | -------------------------------------------------------------------
Requirements Coverage | UC1_Successful_Login
                      | UC1_Unsuccessful_Login
--------------------- | -------------------------------------------------------------------
Input Data            | UC1_Successful_Login : A client's username and password.
                      | UC1_Unsuccessful_Login : A non-existing username and password.
--------------------- | -------------------------------------------------------------------
Procedure             | 1. The user opens the application.
                      | 2. The user provides a user name.
                      | 3. The user provides a password.
                      | 4. The user logs into the application and the system checks
                      |    credentials.
                      | 5. Application decides whether to let the user into the system or
                      |    exit the program.
--------------------- | -------------------------------------------------------------------
Expected Outcome      | If the user credentials check out, the login panel closes and the
                      | UI is displayed. If the user credential check fails, an error
                      | notification pops up and the application closes.
--------------------- | -------------------------------------------------------------------
Notes                 | N/A
-------------------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------
Test ID               | TC_CoinGecko_AddRemoveTradeBroker_1
--------------------- | -------------------------------------------------------------------
Category              | The feature of adding, editing and removing trading brokers is
                      | being tested.
--------------------- | -------------------------------------------------------------------
Requirements Coverage | UC2_Add_Row_Name_Exists
                      | UC2_Add_Row_Name_DNE
                      | UC2_Remove_Row
                      | UC2_Edit_Existing_Broker
--------------------- | -------------------------------------------------------------------
Input Data            | UC2_Add_Row_Name_Exists : The broker's name as well as thier coins
                      |                           and trading strategy.
                      | UC2_Add_Row_Name_DNE : The broker's name as well as thier coins and
                      |                        trading strategy.
                      | UC2_Remove_Row : The name of the broker to remove.
                      | UC2_Edit_Existing_Broker : The broker to update as well as their
                      |                            new coins and trading strategy.
--------------------- | -------------------------------------------------------------------
Procedure             | 1. The user clicks the “Add row” button.
                      | 2. The user enters their desired information.
                      | 3. The user clicks on another row to edit the information however
                      |    they like.
                      | 4. The user clicks on a row and then clicks the “Remove row” button
                      |    to remove a row.
--------------------- | -------------------------------------------------------------------
Expected Outcome      | If the user adds or edits a row and the trading client’s name is
                      | unique, then the data is stored. Otherwise, a notification appears
                      | and the information is not stored. If the user removes a row, the
                      | data is deleted.
--------------------- | -------------------------------------------------------------------
Notes                 | -This UC continues to wait for events and only stops when the user
                      |  decides to close the application.
-------------------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------
Test ID               | TC_CoinGecko_PerformTrade_1
--------------------- | -------------------------------------------------------------------
Category              | The retrieval of cryptocoin prices, the sending of said data to the
                      | respective brokers, the computing of the trading strategies and the
                      | displaying of the data that all occurs after the “Perform trade”
                      | button is being tested.
--------------------- | -------------------------------------------------------------------
Requirements Coverage | UC3_Perform_Trade_Button
                      | UC3_Cryptocoin_Price_Retrieval
                      | UC3_Send_Brokers_Cryptocoin_Prices
                      | UC3_Compute_Strategies_Sufficient_Info
                      | UC3_Compute_Strategies_Insufficient_Info
                      | UC3_Display_UI
--------------------- | -------------------------------------------------------------------
Input Data            | UC3_Perform_Trade_Button : *None* (Just activates the "Perform
                      |                            Trade" button)
                      | UC3_Cryptocoin_Price_Retrieval : The cryptocoins of a broker.
                      | UC3_Send_Brokers_Cryptocoin_Prices : The names of the brokers to
                      |                                      send the coin prices to.
                      | UC3_Compute_Strategies_Sufficient_Info : All the info for a broker.
                      | UC3_Compute_Strategies_Insufficient_Info : Insufficient info for a
                      |                                            broker.
                      | UC3_Display_UI : All the data of the brokers and thier data and
                      |                  trade strategies.
--------------------- | -------------------------------------------------------------------
Procedure             | 1. The user clicks the “Perform trade” button.
                      | 2. The system retrieves all the cryptocoin prices.
                      | 3. The system sends the prices to the right brokers.
                      | 4. The system computes the trading strategies.
                      | 5. If the system does not have enough data to compute a strategy,
                      |    system displays an appropriate message and the strategy is
                      |    labeled as “Fail” and the coin price and quantity as “Null”.
                      | 6. The system displays the UI with all the data.
--------------------- | -------------------------------------------------------------------
Expected Outcome      | The UI displays with all the correct cryptocoin prices and data
                      | including the updated data after computing the trading strategies.
--------------------- | -------------------------------------------------------------------
Notes                 | -Testing if both the table and histogram gets displayed and whether
                      |  or not the data is correct shall be tested in
                      |  TC_CoinGecko_DisplayTradeAction_1.
-------------------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------
Test ID               | TC_CoinGecko_DisplayTradeAction_1
--------------------- | -------------------------------------------------------------------
Category              | The display of the histogram and table of the trading activity is
                      | being tested.
--------------------- | -------------------------------------------------------------------
Requirements Coverage | UC4_Display_Histogram
                      | UC4_Display_Table
--------------------- | -------------------------------------------------------------------
Input Data            | UC4_Display_Histogram : The broker data for the histogram.
                      | UC4_Display_Table : The broker data for the table.
--------------------- | -------------------------------------------------------------------
Procedure             | 1. The user clicks the “Perform trade” button.
                      | 2. The table is displayed after the strategy calculations.
                      | 3. The histogram is displayed.
--------------------- | -------------------------------------------------------------------
Expected Outcome      | The histogram and table successfully display with the correct
                      | information.
--------------------- | -------------------------------------------------------------------
Notes                 | N/A
-------------------------------------------------------------------------------------------
