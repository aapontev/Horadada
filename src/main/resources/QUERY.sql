IF OBJECT_ID ('fechatabla_maestra', 'TR') IS NOT NULL
BEGIN
   DROP TRIGGER fechatabla_maestra;
END;
 
GO -- Necesario
CREATE TRIGGER fechatabla_maestra ON dbo.tabla_maestra AFTER INSERT AS 

BEGIN
	UPDATE dbo.tabla_maestra SET fecha_creacion = GETDATE()
	WHERE id_registro=(SELECT id_registro FROM Inserted)
END
GO
TRUNCATE TABLE dbo.tabla_maestra
GO
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora001',  N'SEXO')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora002',  N'MONEDA')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora003',  N'ESTADO_DESPACHO')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora004',  N'OPERADOR_TEL')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora005',  N'TIPO_TEL')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora006',  N'TIPO_PERSONA')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora007',  N'EST_TRANSPORT')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora008',  N'VALOR_IGV')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora009',  N'DOCUMENTOS')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora010',  N'')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora011',  N'TIPO_lICENCIA')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora012',  N'')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora013',  N'TIPO_DOC')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1],  [valor1]) VALUES ( N'0', N'Hora014',  N'UNIDAD_MEDIDA')

INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora001', N'1', NULL, NULL, N'masculino', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora001', N'2', NULL, NULL, N'femenino', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora002', N'1', N'1', N'1', N'soles', N'PEN', N'S/.')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora002', N'2', N'2', N'2', N'dolares', N'USD', N'$.')
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora003', N'1', NULL, NULL, N'sin salir', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora003', N'2', NULL, NULL, N'en ruta', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora003', N'3', NULL, NULL, N'Despachada', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora004', N'1', NULL, NULL, N'Claro', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora004', N'2', NULL, NULL, N'Movistar', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora004', N'3', NULL, NULL, N'Entel', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora005', N'1', NULL, NULL, N'fijo', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora005', N'2', NULL, NULL, N'celular', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora005', N'3', NULL, NULL, N'anexo', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora006', N'1', NULL, NULL, N'chofer', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora006', N'2', NULL, NULL, N'cliente', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora006', N'3', NULL, NULL, N'administrador', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora007', N'1', NULL, NULL, N'disponible', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora007', N'2', NULL, NULL, N'tranportando', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora007', N'3', NULL, NULL, N'no labora', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora003' ,N'4', NULL, NULL, N'no generado', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora008', N'1', NULL, NULL, N'0.18', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora009', N'1', NULL, NULL, N'solicitud', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora009', N'2', NULL, NULL, N'cotizacion', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora009', N'3', NULL, NULL, N'Orden de compra', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora009', N'4', NULL, NULL, N'factura', NULL, NULL)
INSERT [dbo].[tabla_maestra] ( [id_tabla_maestra],  [clave1], [clave2], [clave3], [valor1], [Valor2], [Valor3]) VALUES ( N'Hora009', N'5', NULL, NULL, N'Valorizacion', NULL, NULL)
GO