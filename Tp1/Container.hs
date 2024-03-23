module Container ( Container, newC, destinationC, netC )
 where

data Container = Con String Int deriving (Eq, Show)

newC :: String -> Int -> Container   -- construye un Contenedor dada una ciudad de destino y un peso en toneladas
newC city weight | weight <= 0 = error "El peso del contenedor no puede ser negativo o 0"
                 | city == "" = error "El contenedor debe tener una ciudad como destino"
                 | otherwise = Con city weight

destinationC :: Container -> String  -- responde la ciuda destino del contenedor
destinationC (Con destiny _) = destiny

netC :: Container -> Int             -- responde el peso en toneladas del contenedor
netC (Con _ weight) = weight
