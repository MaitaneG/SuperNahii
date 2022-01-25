using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Data
{
    /**
     * SuperNaaahi Microsoft SQL serverrera konektatzeko
     */
    public class SuperNaaahiDbContext:DbContext
    {
        public SuperNaaahiDbContext(DbContextOptions<SuperNaaahiDbContext> options)
            : base(options)
        {
        }
        public DbSet<SuperNaaahi.Models.Inkesta> Inkesta { get; set; }
        public DbSet<SuperNaaahi.Models.Foroa> Foroa { get; set; }
    }
}
