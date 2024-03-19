{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Eta reduce" #-}
module Vessel ( Vessel, newV, freeCellsV, loadV, unloadV, netV )
 where

import Container
import Stack
import Route
import Foreign (free)
import Data.ByteString (elemIndex)

data Vessel = Ves [ Stack ] Route deriving (Eq, Show)

newV :: Int -> Int -> Route -> Vessel  -- construye un barco según una cantidad de bahias, la altura de las mismas y una ruta
newV bahias altura route = Ves (replicate bahias (newS altura)) route -- puedo tener /= cant de bahias que de rutas 

freeCellsV :: Vessel -> Int            -- responde la celdas disponibles en el barco
freeCellsV (Ves pilas ruta) = sum (map freeCellsS pilas)

loadV :: Vessel -> Container -> Vessel -- carga un contenedor en el barco
loadV (Ves pilas ruta) container | freeCellsV (Ves pilas ruta) == 0  = error "No hay espacio en el barco"
                                 | otherwise = Ves (stackS (pilas !! pilaMenorCantidad) container ) ruta
                                    where pilaMenorCantidad = elemIndex (minimum (map freeCellsS pilas)) (map freeCellsS pilas)

unloadV :: Vessel -> String -> Vessel  -- responde un barco al que se le han descargado los contenedores que podían descargarse en la ciudad


netV :: Vessel -> Int                  -- responde el peso neto en toneladas de los contenedores en el barco
netV (Ves pilas ruta) = sum (map netS pilas)