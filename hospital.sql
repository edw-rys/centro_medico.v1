	-- -----------------------------------------------------
-- Schema centromedico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `centromedico` DEFAULT CHARACTER SET utf8 ;
USE `centromedico` ;

-- -----------------------------------------------------
-- Table `centromedico`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`paciente` (
  `cedula` VARCHAR(13) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `grupo_san` VARCHAR(10) NOT NULL,
  `fecha_nac` DATETIME NOT NULL,
estado int NOT NULL DEFAULT '1',
  PRIMARY KEY (`cedula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`especialidad` (
  `idespecialidad` INT NOT NULL,
  `descripcion` VARCHAR(45) NULL,
estado int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idespecialidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`tipo_emp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`tipo_emp` (
  `idtipo_emp` INT NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `especialidad_id` INT NOT NULL,
  PRIMARY KEY (`idtipo_emp`),
  INDEX `fk_tipo_emp_especialidad_idx` (`especialidad_id` ASC),
  CONSTRAINT `fk_tipo_emp_especialidad`
    FOREIGN KEY (`especialidad_id`)
    REFERENCES `centromedico`.`especialidad` (`idespecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`empleado` (
  `cedula` VARCHAR(13) NOT NULL,
    `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `fecha_nac` DATETIME NOT NULL,
  `tipo_emp_id` INT NOT NULL,
estado int NOT NULL DEFAULT '1',
  PRIMARY KEY (`cedula`),
  INDEX `fk_empleado_tipo_emp1_idx` (`tipo_emp_id` ASC),
  CONSTRAINT `fk_empleado_tipo_emp1`
    FOREIGN KEY (`tipo_emp_id`)
    REFERENCES `centromedico`.`tipo_emp` (`idtipo_emp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`tipo_med`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`tipo_med` (
  `idtipo_med` INT NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idtipo_med`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`laboratorio` (
  `idlaboratorio` INT NOT NULL,
  `laboratorio` VARCHAR(45) NULL,
  PRIMARY KEY (`idlaboratorio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`medicamento` (
  `idmedicamento` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `costo` VARCHAR(45) NULL,
  `tipo_med_id` INT NOT NULL,
  `laboratorio_id` INT NOT NULL,
  `estado` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idmedicamento`),
  INDEX `fk_medicamento_tipo_med1_idx` (`tipo_med_id` ASC),
  INDEX `fk_medicamento_laboratorio1_idx` (`laboratorio_id` ASC),
  CONSTRAINT `fk_medicamento_tipo_med1`
    FOREIGN KEY (`tipo_med_id`)
    REFERENCES `centromedico`.`tipo_med` (`idtipo_med`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicamento_laboratorio1`
    FOREIGN KEY (`laboratorio_id`)
    REFERENCES `centromedico`.`laboratorio` (`idlaboratorio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`stock_med`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`stock_med` (
  `medicamento_id` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_stock_med_medicamento1_idx` (`medicamento_id` ASC),
  CONSTRAINT `fk_stock_med_medicamento1`
    FOREIGN KEY (`medicamento_id`)
    REFERENCES `centromedico`.`medicamento` (`idmedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `centromedico`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`consulta` (
  `idconsulta` INT NOT NULL auto_increment,
  `descripcion` VARCHAR(45) NULL,
  `costo` DOUBLE NULL,
   cipaciente VARCHAR(45),
CONSTRAINT `fk_consulta_cipaciente`
    FOREIGN KEY (cipaciente)
    REFERENCES `centromedico`.`paciente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  PRIMARY KEY (`idconsulta`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `centromedico`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`factura` (
  `idfactura` INT NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  subtotal DOUBLE NOT NULL,
  `iva` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `cedulaPaciente` varchar(13) NOT NULL,  
  `consulta_id` INT NOT NULL,
  PRIMARY KEY (`idfactura`),
  INDEX `fk_factura_paciente1_idx` (`cedulaPaciente` ASC),
INDEX `fk_detalle_factura_consulta1_idx` (`consulta_id` ASC),
  CONSTRAINT `fk_factura_paciente1`
    FOREIGN KEY (`cedulaPaciente`)
    REFERENCES `centromedico`.`paciente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

CONSTRAINT `fk_factura_consulta1`
    FOREIGN KEY (`consulta_id`)
    REFERENCES `centromedico`.`consulta` (`idconsulta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;





-- -----------------------------------------------------
-- Table `centromedico`.`detalle_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`detalle_factura` (
  `factura_id` INT NOT NULL,
  `cantidad` DOUBLE NULL,
  `precio` DOUBLE NULL,
  `total` DOUBLE NULL,
  `medicamento_id` INT NOT NULL,
  
  INDEX `fk_detalle_factura_factura1_idx` (`factura_id` ASC),
  INDEX `fk_detalle_factura_medicamento1_idx` (`medicamento_id` ASC),
  CONSTRAINT `fk_detalle_factura_factura1`
    FOREIGN KEY (`factura_id`)
    REFERENCES `centromedico`.`factura` (`idfactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_factura_medicamento1`
    FOREIGN KEY (`medicamento_id`)
    REFERENCES `centromedico`.`medicamento` (`idmedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`sintomas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`sintomas` (
  `idsintomas` INT NOT NULL auto_increment,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idsintomas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`tratamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`tratamiento` (
  `idtratamiento` INT NOT NULL auto_increment,
  `cedulaPaciente` VARCHAR(13) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idtratamiento`),
  INDEX `fk_tratamiento_paciente1_idx` (`cedulaPaciente` ASC),
  CONSTRAINT `fk_tratamiento_paciente1`
    FOREIGN KEY (`cedulaPaciente`)
    REFERENCES `centromedico`.`paciente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`muestra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`muestra` (
  `idmuestra` INT NOT NULL auto_increment,
  `peso` DOUBLE NOT NULL,
  `estatura` DOUBLE NOT NULL,
  `presion` VARCHAR(25) NOT NULL,
  `cedulaPaciente` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`idmuestra`),
  INDEX `fk_muestra_paciente1_idx` (`cedulaPaciente` ASC),
  CONSTRAINT `fk_muestra_paciente1`
    FOREIGN KEY (`cedulaPaciente`)
    REFERENCES `centromedico`.`paciente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`historia_medica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`historia_medica` (
  `fecha_ing` DATETIME NULL,
  `muestra_id` INT NOT NULL,
  `cedulaEmpleado` varchar(13) NOT NULL,
  `sintomas_id` INT NOT NULL,
  `tratamiento_id` INT NOT NULL,
  INDEX `fk_historia_medica_empleado1_idx` (`cedulaEmpleado` ASC),
  INDEX `fk_historia_medica_sintomas1_idx` (`sintomas_id` ASC),
  INDEX `fk_historia_medica_tratamiento1_idx` (`tratamiento_id` ASC),
  INDEX `fk_historia_medica_muestra1_idx` (`muestra_id` ASC),
  CONSTRAINT `fk_historia_medica_empleado1`
    FOREIGN KEY (`cedulaEmpleado`)
    REFERENCES `centromedico`.`empleado` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historia_medica_sintomas1`
    FOREIGN KEY (`sintomas_id`)
    REFERENCES `centromedico`.`sintomas` (`idsintomas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historia_medica_tratamiento1`
    FOREIGN KEY (`tratamiento_id`)
    REFERENCES `centromedico`.`tratamiento` (`idtratamiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historia_medica_muestra1`
    FOREIGN KEY (`muestra_id`)
    REFERENCES `centromedico`.`muestra` (`idmuestra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centromedico`.`detalle_tratamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centromedico`.`detalle_tratamiento` (
  `tratamiento_id` INT NOT NULL,
  `medicamento_id` INT NOT NULL,
  `cantidad` VARCHAR(45) NOT NULL,
  `veces_x_dia` VARCHAR(45) NOT NULL,
  `fecha_inicio` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_fin` DATETIME NOT NULL,
  INDEX `fk_detalle_tratamiento_tratamiento1_idx` (`tratamiento_id` ASC),
  INDEX `fk_detalle_tratamiento_medicamento1_idx` (`medicamento_id` ASC),
  CONSTRAINT `fk_detalle_tratamiento_tratamiento1`
    FOREIGN KEY (`tratamiento_id`)
    REFERENCES `centromedico`.`tratamiento` (`idtratamiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_tratamiento_medicamento1`
    FOREIGN KEY (`medicamento_id`)
    REFERENCES `centromedico`.`medicamento` (`idmedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `centromedico`.`usuarios` (
    usuario varchar(15) not null,
    clave varchar(15) not null,
tipo varchar(15) not null,
    estado int NOT NULL DEFAULT '1'

);

create TABLE centromedico.procedimientos(
    idprocedimientos int PRIMARY KEY not null auto_increment,
    nombre varchar(20) not null,
    precio double not null
);

create table centromedico.procedimientos_hechos(
	cedula_paciente varchar(13) not null,
    id_procedimiento int not null,
    id_factura int not null,
    FOREIGN KEY(cedula_paciente) references `centromedico`.paciente(cedula),
    FOREIGN KEY(id_procedimiento) references `centromedico`.procedimientos(idprocedimientos),
    FOREIGN KEY(id_factura) references `centromedico`.factura(idfactura)
);
INSERT INTO `centromedico`.procedimientos (`idprocedimientos`, `nombre`, `precio`) VALUES ('1', 'EXAMEN SANGRE', '10'), ('2', 'RADIOGRAFIA', '30');

INSERT into  `centromedico`.`usuarios` VALUES('admin','12345','ADMINISTRADOR',1);
INSERT into  `centromedico`.`usuarios` VALUES('operador','12345','OPERADOR',1);