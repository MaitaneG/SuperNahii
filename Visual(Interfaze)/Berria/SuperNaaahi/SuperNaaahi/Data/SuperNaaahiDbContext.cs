﻿using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Data
{
    public class SuperNaaahiDbContext:DbContext
    {
        public SuperNaaahiDbContext(DbContextOptions<SuperNaaahiDbContext> options)
            : base(options)
        {
        }
        public DbSet<SuperNaaahi.Models.Inkesta> Inkesta { get; set; }
    }
}
