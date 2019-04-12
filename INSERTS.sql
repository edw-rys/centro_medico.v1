-- ESPECALIDAD 	

INSERT INTO centromedico.`especialidad` (`idespecialidad`, `descripcion`) VALUES ('745', 'DERMATOLOGO'), ('652', 'MEDICINA GENERAL');
INSERT INTO centromedico.`especialidad` (`idespecialidad`, `descripcion`)  VALUES ('962', 'OFTAMOLOGO'), ('222', 'GINECOLOGO');

-- tipo emp
INSERT INTO centromedico.`tipo_emp` (`idtipo_emp`, `descripcion`, `especialidad_id`) VALUES ('745', 'DERMATOLOGO', '745'), ('222', 'DOCTOR', '222');
INSERT INTO centromedico.`tipo_emp` (`idtipo_emp`, `descripcion`, `especialidad_id`) VALUES ('962', 'DOCTOR', '962'), ('652', 'DOCTOR', '652');

-- empl
INSERT INTO centromedico.`empleado` (`cedula`, `nombre`, `apellido`, `edad`, `fecha_nac`, `tipo_emp_id`) VALUES ('0123456789', 'Roberto ', 'Rodriguez', '35', '1982-01-23 00:00:00', '745'), ('9876543210', 'Luis', 'Aguirre', '35', '1984-01-15 00:00:00', '652');
INSERT INTO centromedico.`empleado` (`cedula`, `nombre`, `apellido`, `edad`, `fecha_nac`, `tipo_emp_id`) VALUES ('2135640789', 'Daniela', 'Beltran', '30', '1988-12-10 00:00:00', '222'), ('0321596874', 'Maria', 'Andrade', '30', '1988-10-16 00:00:00', '962');
-- PACIENTE
INSERT INTO centromedico.`paciente` (`cedula`, `nombre`, `apellido`, `edad`, `grupo_san`, `fecha_nac`) VALUES ('3216504789', 'Antony', 'V', '19', 'B+', '1999-10-16 00:00:00'), ('9807365214', 'Gabriel', 'M', '25', 'O+', '1994-01-02 ');
INSERT INTO centromedico.`paciente` (`cedula`, `nombre`, `apellido`, `edad`, `grupo_san`, `fecha_nac`) VALUES ('0987526341', 'Maria', 'Merced', '57', 'O-', '1962-09-19 00:00:00'), ('6325897410', 'Gaby', 'Mercedes', '50', 'A-', '1969-12-17 00:00:00');

-- muestra
INSERT INTO centromedico.`muestra` (`idmuestra`, `peso`, `estatura`, `presion`, `cedulaPaciente`) VALUES ('1', '60.2', '1.25', '26', '0987526341'), ('2', '45.3', '1.50', '3', '3216504789');
INSERT INTO centromedico.`muestra` (`idmuestra`, `peso`, `estatura`, `presion`, `cedulaPaciente`) VALUES ('3', '60.21', '1.58', '63', '9807365214'), ('4', '75', '1.29', '25', '9807365214');
INSERT INTO centromedico.`muestra` (`idmuestra`, `peso`, `estatura`, `presion`, `cedulaPaciente`) VALUES ('5', '65.3', '1.25', '65', '6325897410');

-- sintomas
INSERT INTO centromedico.`sintomas` (`idsintomas`, `descripcion`) VALUES ('1', 'vomitos'), ('2', 'dolor de cabeza');

-- tratamientos
INSERT INTO centromedico.`tratamiento` (`idtratamiento`, `cedulaPaciente`, `fecha`) VALUES ('100', '0987526341', '2018-11-05 00:00:00'), ('101', '3216504789', '2019-01-24 00:00:00');
INSERT INTO centromedico.`tratamiento` (`idtratamiento`, `cedulaPaciente`, `fecha`) VALUES ('103', '6325897410', CURRENT_TIMESTAMP), ('105', '6325897410', '2019-01-01 00:00:00');
INSERT INTO centromedico.`tratamiento` (`idtratamiento`, `cedulaPaciente`, `fecha`) VALUES ('104', '0987526341', '2018-11-12 00:00:00');
INSERT INTO centromedico.`tratamiento` (`idtratamiento`, `cedulaPaciente`, `fecha`) VALUES ('106', '9807365214', CURRENT_TIMESTAMP), ('107', '9807365214', '2018-10-17 00:00:00');

-- TIPO MED
INSERT INTO centromedico.`tipo_med` (`idtipo_med`, `descripcion`) VALUES ('10001', 'TTX'), ('10002', 'MMTX');

-- LABORA
INSERT INTO centromedico.`laboratorio` (`idlaboratorio`, `laboratorio`) VALUES ('2525', 'ORG TN'), ('3636', 'COMPANY FRMX');

-- MEDICINA
INSERT INTO centromedico.`medicamento` (`idmedicamento`, `nombre`, `costo`, `tipo_med_id`, `laboratorio_id`, `estado`) VALUES ('10', 'PARACETAMOL', '10', '10002', '3636', '1'), ('11', 'ACETAMINOFEM', '9', '10001', '3636', '1');
INSERT INTO centromedico.`medicamento` (`idmedicamento`, `nombre`, `costo`, `tipo_med_id`, `laboratorio_id`, `estado`) VALUES ('13', 'ACTN', '15', '10002', '2525', '1'), ('14', 'STCL', '5', '10002', '2525', '1');
INSERT INTO centromedico.`medicamento` (`idmedicamento`, `nombre`, `costo`, `tipo_med_id`, `laboratorio_id`, `estado`) VALUES ('15', 'GSFC', '4', '10001', '3636', '1'), ('16', 'TETRACICLINA', '9', '10001', '2525', '1');

-- DETALL TRAT
INSERT INTO centromedico.`detalle_tratamiento` (`tratamiento_id`, `medicamento_id`, `cantidad`, `veces_x_dia`, `fecha_inicio`, `fecha_fin`) VALUES ('100', '11', '20', '2', '2019-01-08 00:00:00', '2019-01-31 00:00:00'), ('104', '15', '10', '1', '2019-01-09 00:00:00', '2019-01-30 00:00:00');
INSERT INTO centromedico.`detalle_tratamiento` (`tratamiento_id`, `medicamento_id`, `cantidad`, `veces_x_dia`, `fecha_inicio`, `fecha_fin`) VALUES ('105', '15', '14', '2', '2019-01-01 00:00:00', '2019-01-30 00:00:00'), ('103', '13', '20', '3', CURRENT_TIMESTAMP, '2019-01-29 00:00:00');
INSERT INTO centromedico.`detalle_tratamiento` (`tratamiento_id`, `medicamento_id`, `cantidad`, `veces_x_dia`, `fecha_inicio`, `fecha_fin`) VALUES ('107', '16', '10', '1', CURRENT_TIMESTAMP, '2019-01-29 00:00:00'), ('106', '14', '10', '1', CURRENT_TIMESTAMP, '2019-01-22 00:00:00');
INSERT INTO centromedico.`detalle_tratamiento` (`tratamiento_id`, `medicamento_id`, `cantidad`, `veces_x_dia`, `fecha_inicio`, `fecha_fin`) VALUES ('105', '14', '12', '2', CURRENT_TIMESTAMP, '2019-01-29 00:00:00'), ('101', '10', '12', '1', CURRENT_TIMESTAMP, '2019-01-28 00:00:00');
INSERT INTO centromedico.`detalle_tratamiento` (`tratamiento_id`, `medicamento_id`, `cantidad`, `veces_x_dia`, `fecha_inicio`, `fecha_fin`) VALUES ('104', '16', '14', '3', CURRENT_TIMESTAMP, '2019-01-28 00:00:00'), ('101', '14', '12', '1', CURRENT_TIMESTAMP, '2019-01-27 00:00:00');


-- stock med
INSERT INTO centromedico.`stock_med` (`medicamento_id`, `cantidad`, `fecha`) VALUES ('11', '100', CURRENT_TIMESTAMP), ('13', '500', CURRENT_TIMESTAMP);
INSERT INTO centromedico.`stock_med` (`medicamento_id`, `cantidad`, `fecha`) VALUES ('15', '65', CURRENT_TIMESTAMP), ('10', '200', CURRENT_TIMESTAMP);
INSERT INTO centromedico.`stock_med` (`medicamento_id`, `cantidad`, `fecha`) VALUES ('14', '150', CURRENT_TIMESTAMP), ('16', '140', CURRENT_TIMESTAMP);

--  Historia medica

INSERT INTO centromedico.`historia_medica` (`fecha_ing`, `muestra_id`, `cedulaEmpleado`, `sintomas_id`, `tratamiento_id`) VALUES ('2019-01-16 00:00:00', '1', '0123456789', '2', '100'), ('2019-01-23 00:00:00', '2', '0321596874', '1', '101');
INSERT INTO centromedico.`historia_medica` (`fecha_ing`, `muestra_id`, `cedulaEmpleado`, `sintomas_id`, `tratamiento_id`) VALUES ('2019-01-09 00:00:00', '5', '0123456789', '1', '103'), ('2019-01-09 00:00:00', '1', '2135640789', '1', '104');
INSERT INTO centromedico.`historia_medica` (`fecha_ing`, `muestra_id`, `cedulaEmpleado`, `sintomas_id`, `tratamiento_id`) VALUES ('2019-01-08 00:00:00', '5', '2135640789', '1', '105');
INSERT INTO centromedico.`historia_medica` (`fecha_ing`, `muestra_id`, `cedulaEmpleado`, `sintomas_id`, `tratamiento_id`) VALUES ('2019-01-16 00:00:00', '4', '9876543210', '1', '107');
INSERT INTO centromedico.`historia_medica` (`fecha_ing`, `muestra_id`, `cedulaEmpleado`, `sintomas_id`, `tratamiento_id`) VALUES ('2019-01-24 00:00:00', '3', '0321596874', '1', '106');