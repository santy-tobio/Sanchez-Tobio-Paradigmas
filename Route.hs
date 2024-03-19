{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use newtype instead of data" #-}
module Route ( Route, newR, inOrderR )
 where

import Data.List(elemIndex)

data Route = Rou [ String ] deriving (Eq, Show)

newR :: [ String ] -> Route                    -- construye una ruta segun una lista de ciudades
newR = Rou 

inOrderR :: Route -> String -> String -> Bool  -- indica si la primer ciudad consultada esta antes que la segunda ciudad en la ruta
inOrderR (Rou cities) city1 city2  = elemIndex city1 cities <= elemIndex city2 cities

