module Vessel ( Vessel, newV, freeCellsV, loadV, unloadV, netV )
 where

import Container
import Stack
import Route

data Vessel = Ves [ Stack ] Route deriving (Eq, Show)

newV :: Int -> Int -> Route -> Vessel  -- construye un barco según una cantidad de bahias, la altura de las mismas y una ruta
newV bahias altura route | bahias < 0 = error "La cantidad de bahias no puede ser negativa"
                         | altura < 0 = error "La altura de las bahias no puede ser negativa"
                         | otherwise = Ves (replicate bahias (newS altura)) route 

freeCellsV :: Vessel -> Int            -- responde la celdas disponibles en el barco
freeCellsV (Ves pilas ruta) = sum (map freeCellsS pilas)

loadV :: Vessel -> Container -> Vessel -- carga un contenedor en el barco 
loadV (Ves pilas ruta) container | stackV pilas container ruta == pilas = error "el barco no puede aceptar la carga del contenedor"
                                 | otherwise = Ves (stackV pilas container ruta) ruta

unloadV :: Vessel -> String -> Vessel  -- responde un barco al que se le han descargado los contenedores que podían descargarse en la ciudad
unloadV (Ves pilas ruta) target_city = Ves (map (`popS` target_city) pilas) ruta

netV :: Vessel -> Int                  -- responde el peso neto en toneladas de los contenedores en el barco
netV (Ves pilas ruta) = sum (map netS pilas)

stackV :: [Stack] -> Container -> Route -> [Stack]
stackV [] container _ = []
stackV (x:xs) container ruta | holdsS x container ruta = stackS x container : xs
                             | otherwise = x : stackV xs container ruta
