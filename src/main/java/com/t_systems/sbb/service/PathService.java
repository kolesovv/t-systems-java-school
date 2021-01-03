package com.t_systems.sbb.service;

import com.t_systems.sbb.entity.Path;

import java.util.List;

public interface PathService {
    List<Path> getPaths();

    void savePath (Path path);

    Path getPath(int id);

    void deletePath(int id);
}
