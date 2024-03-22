{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use camelCase" #-}
import Container
import Stack
import Vessel
import Route
import Control.Exception
import System.IO.Unsafe

testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

mdq = "mdq"
paris = "paris"
roma = "roma"
grecia = "grecia"
ruta_corta = newR [roma]
ruta_larga = newR [roma, paris, mdq]
ruta_rara = newR [roma, grecia, roma]
cM1 = newC mdq 10
cM2 = newC mdq 25
cR1 = newC roma 5
cR2 = newC roma 25
cP1 = newC paris 20
cP2 = newC paris 5

emptyS = newS 0
shortS = newS 1
mediumS = newS 2
longS = newS 3
shortLS = stackS shortS cM1
longLS = stackS longS cM1
longXLS = stackS longLS cR1
longXXLS = stackS longXLS cR1

shortV = newV 1 1 ruta_corta
mediumV = newV 2 2 ruta_larga

shortLV = loadV shortV cM1
 

t = [ testF(newR []), -- "R1 construir una ruta"]
      inOrderR ruta_corta roma mdq, -- "R3 ciudades en orden"]
      not (inOrderR ruta_corta paris roma), -- "R4 ciudades en orden"]
      testF (inOrderR ruta_corta paris grecia), -- "R5 ciudades en orden"]
      inOrderR ruta_corta roma roma, -- "R6 ciudades en orden"]
      inOrderR ruta_rara roma grecia, -- "R7 ciudades en orden"]
      not (inOrderR ruta_rara grecia roma), -- "R8 ciudades en orden"]


      destinationC cM1 == "mdq", -- "C1 destino de un contenedor"]
      destinationC cR1 /= "a", -- "C2 destino de un contenedor"]
      testF(newC roma 0), -- "C6 peso de un contenedor"]
      testF(newC mdq (-1)), -- "C7 peso de un contenedor"]
      testF(newC "" 10), -- "C8 destino de un contenedor"]
      netC cM1 == 10, -- "C4 peso de un contenedor"]
      netC cR1 /= 15, -- "C5 peso de un contenedor"]


      testF (newS (-1)), -- "S1 capacidad negativa"]
      not (testF (newS 0)), -- "S1 capacidad negativa"]
      freeCellsS shortS == 1, -- "S2 celdas libres en una pila"]
      freeCellsS shortLS == 0 , -- "S3 apilar un contenedor"
      freeCellsS (stackS shortLS cM2) == -1, -- "S4 celdas libres en una pila"
      netS (stackS shortLS cM2) > 20, -- "S7 peso neto de una pila"
      not (holdsS emptyS cR1 ruta_corta), -- "S6 apilar contenedores"
      not (holdsS shortS cM1 ruta_corta), -- "S6 apilar contenedores"
      not (holdsS shortS cR2 ruta_corta), -- "S6 apilar contenedores"
      holdsS shortS cR1 ruta_corta, -- "S6 apilar contenedores"
      popS longXXLS paris == longXLS, 
      popS emptyS mdq == emptyS,
      
      testF (newV (-1) 1 ruta_corta), -- "V1 cantidad de bahias negativa"
      testF (newV 1 (-1) ruta_corta), -- "V2 altura de las bahias negativa" 
      freeCellsV shortV == 1, -- "V2 celdas libres en un barco"
      freeCellsV (loadV shortV cR1) == 0, -- "V3 celdas libres en un barco"
      not (testF (newV 0 0 ruta_corta)), -- "V4 cantidad de bahias negativa"
      testF (loadV shortV cR2), -- "V4 carga de un contenedor"
      testF (loadV shortV cP1), -- "V4 carga de un contenedor"
      testF (loadV shortLV cR1) -- "V4 carga de un contenedor"
      ]