{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Eta reduce" #-}
{-# HLINT ignore "Redundant bracket" #-}
module Stack ( Stack, newS, freeCellsS, stackS, netS, holdsS, popS )
 where

import Route
import Container

data Stack = Sta [ Container ] Int deriving (Eq, Show)

newS :: Int -> Stack                          -- construye una Pila con la capacidad indicada
newS capacity = Sta [] capacity

freeCellsS :: Stack -> Int                    -- responde la celdas disponibles en la pila
freeCellsS (Sta apilados capacity) = capacity - length apilados

stackS :: Stack -> Container -> Stack         -- apila el contenedor indicado en la pila si no se excede de peso ni de capacidad
stackS (Sta apilados capacity) container  | netS (Sta apilados capacity) + netC container <= 20  && freeCellsS (Sta apilados capacity) + 1 <= capacity = Sta (apilados ++ [container]) capacity
                                          | otherwise = error "El contenedor excede el peso o la capacidad de la bahia"
 
netS :: Stack -> Int                          -- responde el peso neto de los contenedores en la pila
netS (Sta apilados capacity) = sum (map netC apilados)

holdsS :: Stack -> Container -> Route -> Bool -- indica si la pila puede aceptar el contenedor considerando las ciudades en la ruta
holdsS (Sta apilados capacity) container ruta = inOrderR ruta (destinationC container) (destinationC (last apilados)) 

popS :: Stack -> String -> Stack              -- quita del tope los contenedores con destino en la ciudad indicada ¿deberia indicar si no hay contenedores con esa ciudad?
popS (Sta apilados capacity) target_city | null apilados || target_city /= destinationC (last apilados) = Sta apilados capacity
                                         | otherwise = popS (Sta (init apilados) capacity) target_city