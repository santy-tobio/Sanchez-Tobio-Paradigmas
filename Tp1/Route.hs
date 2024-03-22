{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use newtype instead of data" #-}
module Route ( Route, newR, inOrderR )
 where

import Data.List(elemIndex)

data Route = Rou [ String ] deriving (Eq, Show)

newR :: [ String ] -> Route                    -- construye una ruta segun una lista de ciudades
newR cities | length cities == 0 = error "La ruta debe tener al menos una ciudad"
            | otherwise = Rou cities

inOrderR :: Route -> String -> String -> Bool  -- indica si la primer ciudad consultada esta antes que la segunda ciudad en la ruta
inOrderR (Rou cities) city1 city2  | notElem city1 cities || notElem city2 cities = error "Las ciudades no pertenecen a la ruta"
                                   | otherwise = elemIndex city1 cities <= elemIndex city2 cities