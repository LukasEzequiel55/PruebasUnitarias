# Documentación Técnica: Sistema de Cálculo de Compras

## 1. Descripción del Problema
El sistema implementado gestiona la lógica de transacciones comerciales básicas para una plataforma de comercio electrónico. Realiza cálculos críticos como el **subtotal** de productos según precio y cantidad, la **validación de compras** (para evitar cantidades o precios negativos/nulos), el cálculo de **descuentos por volumen**, y el **precio final**. Es fundamental verificar rigurosamente estos cálculos para evitar pérdidas financieras por errores de redondeo, cobros incorrectos a los clientes o aceptación de pedidos inválidos.

## 2. Reglas de Negocio
* **Cálculo del Subtotal:** Se obtiene multiplicando el precio unitario del producto por la cantidad solicitada ($\text{precio} \times \text{cantidad}$).
* **Validación de Compra:** Una compra es considerada válida únicamente si tanto el precio unitario como la cantidad son estrictamente mayores a cero ($precio > 0$ y $cantidad > 0$).
* **Aplicación de Descuento:** Se otorga un descuento del $10\%$ ($0.10$) sobre el subtotal únicamente cuando este sea **igual o superior** a $\$1,000$. Si el subtotal es inferior a $\$1,000$, el descuento aplicado es $\$0$.
* **Precio Final:** Se calcula restando el monto del descuento correspondiente al subtotal original.

## 3. Casos de Prueba

| Caso de Prueba | Datos de Entrada | Resultado Esperado | Resultado Obtenido | Propósito del Caso |
| :--- | :--- | :--- | :--- | :--- |
| **Prueba 1 (Subtotal Inferior)** | Subtotal: $\$999.0$ | $\$0.0$ (Sin descuento) | $\$0.0$ | Verificar que no se aplique descuento cuando el subtotal está por debajo del umbral mínimo de $\$1,000$. |
| **Prueba 2 (Subtotal Exacto)** | Subtotal: $\$1,000.0$ | $\$100.0$ ($10\%$) | $\$100.0$ | Validar el caso límite (fronterizo) donde la compra alcanza exactamente el requisito para el descuento. |
| **Prueba 3 (Subtotal Superior)** | Subtotal: $\$1,500.0$ | $\$150.0$ ($10\%$) | $\$150.0$ | Comprobar el funcionamiento correcto del cálculo porcentual con montos superiores al límite. |

## 4. Resultados de Ejecución
* **Total de pruebas ejecutadas:** $3$
* **Pruebas exitosas (Passed):** $3$
* **Pruebas fallidas (Failed):** $0$
* *Estado:* Todos los casos de prueba superaron la validación en JUnit de forma satisfactoria, confirmando que la lógica cumple con las reglas de negocio establecidas.

## 5. Errores que se pueden Prevenir
1. **Errores de límites o de frontera (Off-by-one):** Previene fallos donde se utilice un operador incorrecto (por ejemplo, usar $>$ en lugar de $\ge$), lo cual rechazaría erróneamente el descuento a compras de exactamente $\$1,000$.
2. **Inconsistencias aritméticas en los tipos de datos decimales:** Evita problemas de precisión monetaria al comparar o calcular porcentajes mediante el uso controlado de tolerancias (`delta`) y tipos estructurados.

## 6. Conclusión
Las pruebas unitarias son pilares indispensables en el desarrollo de software moderno, especialmente en entornos de comercio electrónico. Permiten aislar componentes críticos de negocio —como reglas de descuento y validaciones financieras— asegurando que cualquier cambio futuro en el código no rompa la funcionalidad existente. Esto se traduce en mayor confiabilidad para los usuarios y seguridad financiera para la plataforma.

---

## Reflexión Final
Si el cálculo del descuento fallara específicamente cuando la compra es exactamente de $\$1,000$, la prueba unitaria encargada de detectarlo sería `pruebaDescuentoExacto()` (evaluando un subtotal de $\$1,000.0$). 

* **Consecuencias en la aplicación:** Un fallo en este límite exacto significaría que clientes con compras de $\$1,000$ se quedarían sin su descuento correspondiente (si la condición se programó con un estricto $>$ en lugar de $\ge$), generando fricción, reclamos en soporte técnico o pérdida de confianza en las promociones de la plataforma. Las pruebas unitarias de valores límite evitan precisamente este tipo de errores lógicos silenciosos.