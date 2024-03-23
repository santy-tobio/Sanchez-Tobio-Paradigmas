{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Eta reduce" #-}
{-# HLINT ignore "Redundant bracket" #-}
module Stack ( Stack, newS, freeCellsS, stackS, netS, holdsS, popS )
 where

import Route
import Container
import Data.Binary.Get (isEmpty)
import Control.Applicative (Alternative(empty))
import Distribution.FieldGrammar (List)

data Stack = Sta [ Container ] Int deriving (Eq, Show)

newS :: Int -> Stack                          -- construye una Pila con la capacidad indicada
newS capacity | capacity < 0 = error "La capacidad de la pila no puede ser negativa o 0"
              | otherwise = Sta [] capacity

freeCellsS :: Stack -> Int                    -- responde la celdas disponibles en la pila
freeCellsS (Sta apilados capacity) = capacity - length apilados

stackS :: Stack -> Container -> Stack         -- apila el contenedor indicado en la pila
stackS (Sta apilados capacity) container  = Sta (apilados ++ [container]) capacity

netS :: Stack -> Int                          -- responde el peso neto de los contenedores en la pila
netS (Sta apilados capacity) = sum (map netC apilados)

holdsS :: Stack -> Container -> Route -> Bool -- indica si la pila puede aceptar el contenedor considerando las ciudades en la ruta
holdsS (Sta apilados capacity) container ruta = validoEnLaRuta && validoEnPeso && validoEnCeldas
                where validoEnLaRuta = isEmptyS apilados && (inOrderR ruta (destinationC container) (destinationC container)) || inOrderR ruta (destinationC container) (destinationC (last apilados)) 
                      validoEnPeso = netS (Sta (apilados ++ [container]) capacity) <= 20
                      validoEnCeldas = freeCellsS (Sta (apilados ++ [container]) capacity) >= 0

popS :: Stack -> String -> Stack              -- quita del tope los contenedores con destino en la ciudad indicada
popS (Sta apilados capacity) target_city | isEmptyS apilados || target_city /= destinationC (last apilados) = Sta apilados capacity
                                         | otherwise = popS (Sta (init apilados) capacity) target_city

isEmptyS :: [a] -> Bool 
isEmptyS apilados = null apilados