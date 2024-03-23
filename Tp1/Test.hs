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
longXXLS = stackS longXLS cP1

shortV = newV 1 1 ruta_corta
mediumV = newV 2 2 ruta_larga

shortLV = loadV shortV cM1
 

t = [ testF(newR []), 
      inOrderR ruta_larga roma mdq, 
      not (inOrderR ruta_larga paris roma),
      testF (inOrderR ruta_larga paris grecia), 
      inOrderR ruta_corta roma roma, 
      inOrderR ruta_rara roma grecia, 
      not (inOrderR ruta_rara grecia roma), 


      destinationC cM1 == "mdq", 
      destinationC cR1 /= "a",
      testF(newC roma 0), 
      testF(newC mdq (-1)), 
      testF(newC "" 10),
      netC cM1 == 10, 
      netC cR1 /= 15, 


      testF (newS (-1)), 
      not (testF (newS 0)), 
      freeCellsS shortS == 1,
      freeCellsS shortLS == 0 ,
      freeCellsS (stackS shortLS cM2) == -1,
      netS (stackS shortLS cM2) > 20,
      not (holdsS emptyS cR1 ruta_corta),
      testF (not (holdsS shortS cM1 ruta_corta)), --arreglaDO
      not (holdsS shortS cR2 ruta_corta),
      holdsS shortS cR1 ruta_corta,
      popS longXXLS paris == longXLS, 
      popS emptyS mdq == emptyS,
      
      testF (newV (-1) 1 ruta_corta),
      testF (newV 1 (-1) ruta_corta),
      freeCellsV shortV == 1,
      freeCellsV (loadV shortV cR1) == 0, 
      not (testF (newV 0 0 ruta_corta)), 
      testF (loadV shortV cR2), 
      testF (loadV shortV cP1), --arreglaDOs
      testF (loadV shortLV cR1) 
      ]